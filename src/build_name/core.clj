(ns build-name.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.pprint :as pp]
            [build-name.names.generate :refer [generate-name append-id append-date]])
  (:gen-class))

(def cli-options [[nil "--version" "Version number" :id :version]
                  ["-i" "--integer" "Add integer to name" :id :integer]
                  ["-d" "--date" "Add date to name" :id :date]
                  ["-n" "--number NUMBER" "Number of items to generate" :default 1 :parse-fn #(Integer/parseInt %)]
                  ["-a" "--alliterate" "Make sure the word pairs are alliterative" :id :alliterate]])

(def func-map {:date append-date :integer append-id})

(defn apply-modifier [name [option]]
  (apply (get-in func-map [option]) [name]))

(defn generate-names [modifiers]
  (if (contains? modifiers :alliterate)
    (reduce apply-modifier (generate-name true) (apply dissoc modifiers [:alliterate]))
    (reduce apply-modifier (generate-name) (apply dissoc modifiers [:alliterate]))))

(defn -main
  "Generate a random noun-adjective name pair."
  [& args]
  (let [opts (parse-opts args cli-options)
        num-to-gen (get-in opts [:options :number])
        modifiers (apply dissoc (get-in opts [:options]) [:version :number])
        output (repeatedly num-to-gen #(generate-names modifiers))]
    (pp/pprint output)))
