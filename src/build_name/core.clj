(ns build-name.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [build-name.names.generate :refer [generate-name append-id append-date]])
  (:gen-class))

(def cli-options [[nil "--version" "Version number" :id :version]
                  ["-i" "--integer" "Add integer to name" :id :integer]
                  ["-d" "--date" "Add date to name" :id :date]
                  ;; TODO: Add support for number options
                  ["-n" "--number NUMBER" "Number of items to generate" :default 10 :parse-fn #(Integer/parseInt %)]
                  ;; TODO: Support alliteration in generate-names function
                  ["-a" "--alliterate" "Make sure the word pairs are alliterative" :id :alliterate]])

(def func-map {:date append-date :integer append-id})

(defn apply-modifier [name [option]]
  (apply (get-in func-map [option]) [name]))

(defn generate-names [modifiers]
  (reduce apply-modifier (generate-name) modifiers))

(defn -main
  "Generate a random noun-adjective name pair."
  [& args]
  (let [opts (parse-opts args cli-options)
        num-to-gen (get-in opts [:options :number])
        modifiers (apply dissoc (get-in opts [:options]) [:version :number :alliterate])
        output (repeat num-to-gen (generate-names modifiers))]
    (println opts)
    (println output)))



