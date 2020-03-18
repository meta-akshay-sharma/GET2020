//Program to Implement Stack
var stack = function() {
    this.top = -1;
    this.array = [];
    this.pushItem = function(element) {
        this.array.push(element);
        this.top += 1;
    }
    this.popItem = function() {
        if (this.top == -1) {
            console.log("Stack is empty");
        } else {
            this.array.pop();
            this.top -= 1;
        }
    }
}


obj = new stack();
obj.pushItem(20);
obj.pushItem(40);
obj.array;
obj.popItem();
obj.array;