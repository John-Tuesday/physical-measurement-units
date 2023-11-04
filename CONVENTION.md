# Convention

This documents the conventions used in writing this library.

---

# Usage

## Obtaining instances

Classes can be created
using [constructor-like functions](https://kotlinlang.org/docs/jvm-api-guidelines-readability.html#use-constructor-like-functions-where-applicable).

For example, to construct an instance of class `Energy`, use the function with the same name.

    public fun Energy(...): Energy

Measurement types, e.g. `Energy` and `Length`, can also be created using the `Number` property extension with the
corresponding name of the desired unit.

To create a `Length` representing 9 meters, you can use the following

    9.meters

---

# Full Details

## Class constructors

Public classes should not have public constructor; instead,
public [constructor-like functions](https://kotlinlang.org/docs/jvm-api-guidelines-readability.html#use-constructor-like-functions-where-applicable)
should be used to create instances of the class.

## Mutability

Every public type should be as immutable as possible. Any mutable type should have `Mutable` in its name.
