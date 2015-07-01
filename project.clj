(defproject contact-form "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [http-kit "2.1.19"]
                 [compojure "1.3.4"]
                 [org.clojure/java.jdbc "0.3.7"]
                 [postgresql "9.3-1102.jdbc41"]
                 [ring/ring-jetty-adapter "1.3.2"]]
  :uberjar-name "contact-form.jar"
  :main ^:skip-aot contact-form.core
  :profiles {:uberjar {:aot :all}})
