package sample.quadtree

import sample.Segment

class Box {
    var xCenter = 0
    var yCenter = 0
    var halfDimension = 0

    constructor(xCenter: Int, yCenter: Int, halfDimension: Int) {
        this.xCenter = xCenter
        this.yCenter = yCenter
        this.halfDimension = halfDimension
    }


    fun containsSegment(s : Segment) : Boolean {
        return false
    }
    fun intersectsWithOtherBox(other : Box) : Boolean {
        return false
    }
}