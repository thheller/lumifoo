(ns lumifoo.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [lumifoo.core-test]))

(doo-tests 'lumifoo.core-test)

