(ns my-cljapplied.ch1.validate
  ;; (:require [schema.core :as s])
  )

(defrecord Recipe
    [name
     description
     ingredients
     steps
     servings ])


(defrecord Ingredient
    [name
     quantity
     unit ])


(def spaghetti-tacos
  (map->Recipe
   {:name        "Spaghetti Tacos"
    :description "It's spaghetti... in a taco."
    :ingredients [(->Ingredient "Spaghetti" 1 :lb)
                  (->Ingredient "Spaghetti" 16 :oz)
                  (->Ingredient "Taco shell" 12 :shell)]
    :steps       ["Cook spaghetti according to box."
                  "Heat spaghetti sauce until warm."
                  "Mix spaghetti and sauce."
                  "Put spaghetti in taco shells and serve."]
    :servings    4}))
