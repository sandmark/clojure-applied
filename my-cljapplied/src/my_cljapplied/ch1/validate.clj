(ns my-cljapplied.ch1.validate)

(defrecord Recipe
    [name description ingredients steps servings])


(defrecord Ingredient
    [name quantity unit])
