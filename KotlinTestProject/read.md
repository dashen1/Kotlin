# Kotlin
# inline function has two main bad sides 
# first: public inline functions cannot use private functions, this could lead to a compilation error.
# solution To prevent this, Kotlin does not permit the use of elements with less restrictive modifiers than the lambda expression in which they are placed.
# second: While no lambda expression has been created, we cannot pass parameters that are of the function type to another function. 
# solution The simplest way to deal with it is by making the function inline as well.

# Extension properties! The only limitation is that this property can't have a backing field.(Because extension can't store state)

# !! what's this mean?

# kotlin-stdlib:1.4.21@jar和 kotlin-stdlib:1.5.10@jar 冲突

# Unresolved reference: BuildConfig