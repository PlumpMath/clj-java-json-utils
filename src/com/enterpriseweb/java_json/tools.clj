(ns com.enterpriseweb.java-json.tools
  (:require [clojure.data.json :as clj-json])
  (:import [org.json JSONObject]))

(defn- create-java-json-object [clojure-json-object]
  (JSONObject. (str clojure-json-object)))

(defn- create-java-json
  ([clojure-json]
     (create-java-json-object clojure-json))
  ([clojure-json & ks]
     (reduce #(.put % (name %2) (%2 clojure-json) ) (JSONObject.) ks)))

(defn clojure-json->java-json [clojure-object]
  (create-java-json (clj-json/write-str clojure-object)))

(defn java-json->clojure-json  [java-json-object]
  (clj-json/read-str (.toString java-json-object) :key-fn keyword))
