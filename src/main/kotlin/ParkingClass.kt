
class ParkingClass {
    private var mapPark = mutableMapOf<Int, String>()
    private val regexLeaving = "leave [0-9]+".toRegex()
    private val regexParking = "park [-A-Za-z0-9]+ [a-zA-Z]+".toRegex()


    fun setAction(action: String) {
        val parkArray = action.split(" ")
        var flag = false
        if (parkArray[0] == "create") {
            mapPark = mutableMapOf()
            for (i in 1..parkArray[1].toInt()) {
                mapPark[i] = "free"

            }
            println("Created a parking lot with ${parkArray[1].toInt()} spots.")
        } else {
            if (mapPark.isEmpty()) {
                println("Sorry, a parking lot has not been created.")
            } else {
                if (action == "status") {
                    for (map in mapPark.entries) {
                        if (map.value != "free") {
                            println("${map.key} ${map.value}")
                            flag = true
                        }
                    }
                    if (!flag) {
                        println("Parking lot is empty.")
                    }

                } else if (action.matches(regexParking)) {
                    flag = false
                    for (map in mapPark.entries) {
                        if (map.value == "free") {
                            println("${parkArray[parkArray.size - 1]} car parked in spot ${map.key}.")
                            mapPark[map.key] = parkArray[1] + " " + parkArray[2]
                            flag = true
                            break
                        }
                    }
                    if (!flag) {
                        println("Sorry, the parking lot is full.")
                    }
                } else if (action.matches(regexLeaving)) {
                    if (mapPark[(parkArray[1]).toInt()] == "free") {
                        println("There is no car in spot ${parkArray[1]}.")

                    } else {
                        mapPark[(parkArray[1]).toInt()] = "free"
                        println("Spot ${parkArray[1]} is free.")
                    }
                } else if (parkArray[0] == "reg_by_color") {
                    flag = false
                    val listReg = ArrayList<String>()
                    for (map in mapPark.entries) {
                        if (map.value.lowercase().contains(parkArray[1].lowercase())) {
                            listReg.add(map.value.split(" ")[0])
                            flag = true
                        }
                    }

                    if (!flag) {
                        println("No cars with color ${parkArray[1]} were found.")
                    } else {
                        listReg.forEach {
                            if (listReg.indexOf(it) == listReg.size - 1)
                                print(it) else print("$it, ")
                        }
                        println()
                    }
                } else if (parkArray[0] == "spot_by_color") {
                    flag = false
                    val listSpot = ArrayList<String>()
                    for (map in mapPark.entries) {
                        if (map.value.lowercase().contains(parkArray[1].lowercase())) {
                            listSpot.add(map.key.toString())
                            flag = true
                        }

                    }
                    if (!flag) {
                        println("No cars with color ${parkArray[1]} were found.")
                    } else {
                        listSpot.forEach {
                            if (listSpot.indexOf(it) == listSpot.size - 1)
                                print(it) else print("$it, ")
                        }
                        println()
                    }
                } else if (parkArray[0] == "spot_by_reg") {
                    flag = false
                    for (map in mapPark.entries) {
                        if (map.value.split(" ")[0].lowercase() == parkArray[1].lowercase()) {
                            println(map.key.toString())
                            flag = true
                        }
                    }
                    if (!flag) {
                        println("No cars with registration number ${parkArray[1]} were found.")
                    }
                }
            }
        }
    }
}