-module(fibonacci).
-export([fibonacci_iterative/1]).

fibonacci_iterative(Position) when Position >= 0 ->
    case Position of
        0 -> [1];
        1 -> [1, 1];
        _ ->
            lists:reverse(lists:foldl(
                fun(_, [Prev, Current | Rest]) -> [Prev + Current, Prev | Rest] end,
                [1, 1],
                lists:seq(2, Position - 1)
            ))
    end.



fibonacci_recursive(Position) when Position >= 0 ->
    case Position of
        0 -> [1];
        1 -> [1, 1];
        _ ->
            [1 | fibonacci_recursive(Position - 1, 2, [1, 1])]
    end.

fibonacci_recursive(Position, Index, [PreviousPrevious, Previous | Accumulator]) when Index < Position ->
    NewNumber = PreviousPrevious + Previous,
    fibonacci_recursive(Position, Index + 1, [Previous | [NewNumber | Accumulator]]).

fibonacci_recursive(_, _, Accumulator) ->
    lists:reverse(Accumulator).



fibonacci_recursive_iterative(Position) when Position >= 0 ->
    fibonacci_recursive_iterative(Position, 0, 1, 1, []).

fibonacci_recursive_iterative(0, _, _, _, Accumulator) ->
    lists:reverse([1 | Accumulator]);

fibonacci_recursive_iterative(Position, Index, PreviousPrevious, Previous, Accumulator) when Position > 0 ->
    NewNumber = PreviousPrevious + Previous,
    fibonacci_recursive_iterative(Position - 1, Index + 1, Previous, NewNumber, [Previous | Accumulator]).
