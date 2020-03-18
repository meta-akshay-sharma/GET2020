// Program to implement Singly Linked List
var node = function(element) {
    this.item = element;
    this.next = null;
}

var linkedList = function() {
    this.head = null;
    this.size = 0;
    this.addItem = function(element) {
        var newNode = new node(element);
        if (this.head == null) {
            this.head = newNode;
            this.size += 1;
        } else {
            var traverseNode = this.head;
            while (traverseNode.next != null) {
                traverseNode = traverseNode.next;
            }
            traverseNode.next = newNode;
            this.size += 1;
        }
    }
    this.deleteItem = function(element) {
        var elementFound = false;
        var traverseNode = this.head;
        var previousNode = null;
        while (traverseNode != null) {
            if (traverseNode.item == element) {
                if (previousNode == null) {
                    this.head = traverseNode.next;
                    this.size -= 1;
                } else {
                    previousNode.next = traverseNode.next;
                    this.size -= 1;
                }
                elementFound = true;
                this.size -= 1;
                break;
            }
            previousNode = traverseNode;
            traverseNode = traverseNode.next;
        }
        if (elementFound == true) {
            console.log("Element Deleted");
        } else {
            console.log("Element not found");
        }
    }
    this.displayList = function() {
        var traverseNode = this.head;
        while (traverseNode != null) {
            console.log(traverseNode.item);
            traverseNode = traverseNode.next;
        }
    }

}

obj = new linkedList();
obj.addItem(10);
obj.addItem(30);
obj.addItem(50);
obj.displayList();
obj.deleteItem(50);
obj.deleteItem(20);
obj.displayList();