# contact-form

This is a backend for a basic contact form (receiving name, email, etc.) that will be hosted on my personal website. The frontend will probably use JQuery or similar to POST a JSON string, which this backend (written in Clojure) will add to a database of responses hosted on Heroku. As such, this is currently a Heroku app on the free tier so the latency of several seconds on waking up from sleep is proving problematic.

## Installation

Download and run in Leiningen after setting the correct environment variables.

## Options

CONTACT_DB environment variable is a PostgreSQL link to my contact form responses database, which has a relation `responses` with columns for each form field.

### Bugs

Currently doesn't actually handle form POST data. Working on bypassing this by switching to JSON, a better choice in the long-term anyway.

...
