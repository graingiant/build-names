(ns build-name.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [build-name.names.generate :refer [generate-name append-id append-date]])
  (:gen-class))

(def cli-options [[nil "--version" "Version number" :id :version]
                  ["-i" "--integer" "Add integer to name" :id :integer]
                  ["-d" "--date" "Add date to name" :id :date]
                  ;; TODO: Add support for number options
                  ["-n" "--number" "Number of items to generate" :id :number]])

(def func-map {:date append-date :integer append-id})

(defn -main
  "Generate a random noun-adjective name pair."
  [& args]
  (let [opts (parse-opts args cli-options)]
    (reduce
     (fn [name [option _]] (apply (get-in func-map [option]) [name]))
     (generate-name)
     (apply dissoc (get-in opts [:options]) [:version :number]))))

