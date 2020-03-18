//Program to implement Queue
var queue = function() {
    this.array = [];
    this.enqueue = function(element) {
        this.array.push(element);
    }
    this.dequeue = function() {
        if (this.array.length == 0) {
            console.log("Queue is empty");
        } else {
            this.array.shift();
        }
    }
}


obj = new queue();
obj.enqueue(20);
obj.enqueue(40);
obj.array;
obj.dequeue();
obj.array;