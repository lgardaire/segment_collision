package sample


class Segment {
    var x = 0.0
    var y = 0.0
    var startx = 0.0
    var starty = 0.0
    var endx = 0.0
    var endy = 0.0
    var vx = 0
    var vy = 0
    var angle = (0 until 2*kotlin.math.PI.toInt()).shuffled()[0].toDouble()
    var rotationSpeed = kotlin.math.PI/2
    var length = 80

    constructor(vx: Int, vy: Int, maxX : Double, maxY : Double, fps : Int) {
        this.x = (0 until maxX.toInt()).shuffled()[0].toDouble()
        this.y = (0 until maxY.toInt()).shuffled()[0].toDouble()
        updateExtremities()
        this.vx = vx/fps
        this.vy = vy/fps
        this.rotationSpeed /= fps
    }

    fun updateExtremities() {
        this.startx = this.x - kotlin.math.cos(this.angle)*(this.length/2)
        this.starty = this.y - kotlin.math.sin(this.angle)*(this.length/2)
        this.endx = this.x + kotlin.math.cos(this.angle)*(this.length/2)
        this.endy = this.y + kotlin.math.sin(this.angle)*(this.length/2)
    }

    fun rotate(){
        this.angle += rotationSpeed
    }

    fun translate(){
        this.x += this.vx
        this.y += this.vy
        updateExtremities()
    }

    fun collision(width : Int, height : Int){
        if (this.x >= width || this.x < 0){
            this.angle = kotlin.math.PI - this.angle
            this.vx = -vx
        } else if (this.y >= height|| this.y < 0){
            this.angle = kotlin.math.PI - this.angle
            this.vy = -vy
        }
    }
}