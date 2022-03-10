(ns build-name.names.generate
  (:require [clojure.string :as str]
            [clojure.java.io :refer [resource]])
  (:import (java.time LocalDate)))


(defn get-lines [file]
  (str/split-lines (slurp file)))

(defn get-random [lst] (get lst (rand-int (count lst))))

(def nouns (get-lines (resource "data/nouns.txt")))
(def adjectives (get-lines (resource "data/adjectives.txt")))
(def date-formatted (.toString (LocalDate/now)))

(defn generate-name
  "Generates a name based on a random noun and adjective"
  []
  (let [noun (get-random nouns)
        adjective (get-random adjectives)]
    (str adjective "-" noun)))

(defn append-id [name] (str name "-" (format "%04d" (rand-int 9999))))

(defn append-date [name] (str name "-" date-formatted))
