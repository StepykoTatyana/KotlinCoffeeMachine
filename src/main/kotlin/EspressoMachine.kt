class EspressoMachine {
    private var costPerServing: Float = 0F

    constructor(coffeeCapsulesCount: Int, totalCost: Float) {
        this.costPerServing = totalCost / coffeeCapsulesCount

    }

    constructor(coffeeBeansWeight: Float, totalCost: Float) {
        this.costPerServing = totalCost / (coffeeBeansWeight / 10)
        println(
            """White car has parked.
Yellow car left the parking lot.
Green car just parked here."""
        )

    }



}

