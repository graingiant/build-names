(ns build-name.names.generate
  (:require [clojure.string :as str]
            [clojure.java.io :refer [resource]])
  (:import (java.time LocalDate)))


(defn- get-lines [file]
  (str/split-lines (slurp file)))

(defn- get-random [lst] (get lst (rand-int (count lst))))
(defn- get-random-alliterated [lst starting-letter]
  (let [matched-letter-options (filter #(clojure.string/starts-with? % starting-letter) lst)]
    (first (take 1 (shuffle matched-letter-options)))))

(def nouns (get-lines (resource "data/nouns.txt")))
(def adjectives (get-lines (resource "data/adjectives.txt")))
(def date-formatted (.toString (LocalDate/now)))

(defn- generate-alliterative-name []
  (let [noun (get-random nouns)
        adjective (get-random-alliterated adjectives (subs noun 0 1))]
    (str adjective "-" noun)))

(defn- generate-default-name []
  (let [noun (get-random nouns)
        adjective (get-random adjectives)]
    (str adjective "-" noun)))

(defn generate-name
  "Generates a name based on a random noun + adjective"
  ([_] (generate-alliterative-name))
  ([] (generate-default-name)))

(defn append-id [name] (str name "-" (format "%04d" (rand-int 9999))))

(defn append-date [name] (str name "-" date-formatted))
