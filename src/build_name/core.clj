(ns build-name.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [build-name.names.generate :refer [generate-name append-id append-date]])
  (:gen-class))

(def cli-options [[nil "--version" "Version number" :id :version]
                  ["-i" "--integer" "Append random integer to names generated (Ex: abject-hands-0843)" :id :integer]
                  ["-d" "--date" "Append todays date to the names generates (Ex: abject-hands-2022-03-13)" :id :date]
                  ["-n" "--number NUMBER" "Number of names to generate" :default 1 :parse-fn #(Integer/parseInt %)]
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
    (run! println output)))
