// Task execution listeners

gradle.taskGraph.beforeTask {
    println("before $this")
}

gradle.taskGraph.afterTask {
    println("after $this")
}

val executionListener = object: TaskExecutionListener {
    override fun beforeExecute(task: Task) {
        println("before $task")
    }

    override fun afterExecute(task: Task, state: TaskState) {
        println("after $task")
    }
}

gradle.taskGraph.addTaskExecutionListener(executionListener)

gradle.addListener(executionListener)

// Build finished listeners

gradle.buildFinished {
    println("build finished")
}

val buildListener = object: BuildAdapter() {
    override fun buildFinished(result: BuildResult) {
        println("build finished")
    }
}

gradle.addListener(buildListener)

// Task action problems

tasks.register("broken") {
    doFirst {
        // Task action uses project
        println("project = $project")

        // Task action uses taskDependencies
        println("dependencies = $taskDependencies")
    }
}
