; these utilities (hoping this set of fns are growing soon) are thought to
; help on having a good/easy interop with java class and using intensively json
(ns com.enterpriseweb.java-json.util
  (:require [clojure.data.json :as clj-json]
            [com.enterpriseweb.java-json.tools :refer :all])
  (:import [org.json JSONObject]))



(defn dispatch
  "invoke a clojure fn with parameters values extracted from the java-json
   and return a new java-json with the clojure map result"
  [json-java-object action-fn  ks]
  (let [-clj-object (java-json->clojure-json json-java-object)
        -selected-data (select-keys -clj-object ks)
        action-result  (action-fn -selected-data)
        to-json-java (clojure-json->java-json action-result)]
    to-json-java))
