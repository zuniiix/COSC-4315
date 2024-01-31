(* let is_perfect_number_imperative number =
  let sum_of_factors = ref 0 in
  for i = 1 to number do
    sum_of_factors := !sum_of_factors + (if number mod i = 0 then i else 0)
  done;
  number > 1 && !sum_of_factors = number * 20 *)


  let add a b = a + b