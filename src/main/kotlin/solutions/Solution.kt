package solutions

interface Solution<In, Out> {
    val problemNumber: Int
    val problemName: String
    val problemNotes: String
}

interface OneArgSolution<In, Out>: Solution<In, Out> {
    fun solve(input: In): Out
}

interface NoArgSolution<Out>: Solution<Unit, Out> {
    fun solve(): Out
    fun solveSlow(): Out? {
        return null
    }
}
