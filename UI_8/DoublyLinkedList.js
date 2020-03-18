// Program to implement Doubly Linked List
var node = function(element) {
    this.item = element;
    this.next = null;
    this.prev = null;
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
            newNode.prev = traverseNode;
            traverseNode.next = newNode;

        }
    }
    this.deleteItem = function(element) {
        var elementFound = false;
        var traverseNode = this.head;
        while (traverseNode != null) {
            if (traverseNode.item == element) {
                if (traverseNode.prev == null) {
                    this.head = traverseNode.next;
                } else if (traverseNode.next == null) {
                    traverseNode.prev.next = null;
                } else {
                    traverseNode.prev.next = traverseNode.next;
                    traverseNode.next.prev = traverseNode.prev;
                }
                elementFound = true;
                this.size -= 1;
                break;
            }
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