(ns contact-form.core
  (:gen-class)
  (:require [compojure.core :refer [defroutes POST]]
            [compojure.handler :refer [site]]
            [org.httpkit.server :refer [run-server]]
            [clojure.java.jdbc :as sql]
            [clojure.string :refer [split]]
            [ring.adapter.jetty :as jetty]))

(def ^:const form-params [:name :email :subject :message])

(defn get-port
  []
  (read-string (System/getenv "PORT")))

(defn request->map
  [request]
  (let [query (:query-string request)
        query-map (->> (split query #"&")
                       (map #(split % #"="))
                       (map (fn [[k v]] [(keyword k) v]))
                       (into {}))]
    (select-keys query-map form-params)))

(defn add-to-db
  [data]
  (let [db (System/getenv "CONTACT_DB")]
    (sql/insert! db :responses data)))

(defroutes routes
  (POST "/" request (add-to-db (request->map request))))

(defn -main
  [& args]
  (let [port (get-port)]
    (println (str "Listening on port: " port))
    (jetty/run-jetty (site #'routes) {:port port :join? false})))
