(ns com.enterpriseweb.java-json.protocol
  (:require [com.enterpriseweb.java-json.tools :refer :all])
  (:import [org.json JSONObject]))

(defprotocol asociative
  (assoc+  [this x y])
  (get-in+ [this  nested-ks]))

(extend-protocol asociative
  JSONObject
  (assoc+ [this x y]
    (.put this  (name x) (name y)))
  (get-in+ [this   nested-ks]
    (let [this-clj (java-json->clojure-json this)]
      (get-in this-clj nested-ks)))
  )
