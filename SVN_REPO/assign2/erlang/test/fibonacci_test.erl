-module(fibonacci_test).
-include_lib("eunit/include/eunit.hrl").
-compile([export_all]).

run_fibonacci_tests(FibonacciFunction) ->
    [
        ?_assertEqual([1], FibonacciFunction(0)),
        ?_assertEqual([1, 1], FibonacciFunction(1)),
        ?_assertEqual([1, 1, 2], FibonacciFunction(2)),
        ?_assertEqual([1, 1, 2, 3, 5, 8], FibonacciFunction(5)),
        ?_assertEqual([1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89], FibonacciFunction(10))
    ].

fibonacci_test() ->
    run_fibonacci_tests(fun fibonacci:fibonacci_iterative/1).

fibonacci_recursive_test() ->
    run_fibonacci_tests(fun fibonacci:fibonacci_recursive/1).

fibonacci_recursive_iterative_test() ->
    run_fibonacci_tests(fun fibonacci:fibonacci_recursive_iterative/1).
