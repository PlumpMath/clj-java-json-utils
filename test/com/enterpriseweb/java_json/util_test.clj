(ns com.enterpriseweb.java-json.util-test
  (:require [com.enterpriseweb.java-json.util :refer :all]
            [com.enterpriseweb.java-json.tools :refer :all]
            [clojure.data.json :as clj-json]
            [clojure.test :refer :all]
            [midje.sweet :refer :all]
            ))

(facts "starting ew tests"
       (fact "dispatch fn with parameters values extracted from the java-json  and return java-json "
             (java-json->clojure-json (dispatch (clojure-json->java-json {:a 12}) #(hash-map :b (+ (:a %))) [:a]))  => {:b 12}
             ..a.. => ..a..
             )
       )




#_(deftest test-json-object
  (testing "FIXME, I fail."
    (is (= (iterator-seq (.keys (org.json.JSONObject.))) (iterator-seq(.keys (create-java-json-object (clj-json/write-str {:a "1"}))))))
    ))

(run-tests)
