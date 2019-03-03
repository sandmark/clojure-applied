(ns my-cljapplied.ch1.recipe)

(defrecord Recipe
    [name        ; string
     author      ; recipe
     description ; stromg
     ingredients ; list of ingredients
     steps       ; sequence of string
     servings    ; number of servings
     ])


(defrecord Person
    [fname ; first name
     lname ; last name
     ])
