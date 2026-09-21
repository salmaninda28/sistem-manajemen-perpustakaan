public class Doublelinkedlist {

    Node head;
    Node tail;
    Node current;

    public Doublelinkedlist() {
        head = null;
        tail = null;
        current = null;
    }

    public void add(Book book){   
        Node bukuBaru = new Node(book);
        if (head == null) {
            head = bukuBaru;
            tail = bukuBaru;
            current = bukuBaru;
        } else {
            tail.next = bukuBaru;
            bukuBaru.prev = tail;
            tail = bukuBaru;
        }
    }

    public void delete(String id){
          // Mencari Node berdasarkan ID
        Node temp = head;

        while (temp != null && !temp.data.id.equals(id)) {
            temp = temp.next;
        }

        // Jika ID tidak ditemukan
        if (temp == null) {
            System.out.println("Buku dengan ID " + id + " tidak ditemukan.");
            return;
        }

        // Jika hanya ada satu Node
        if (temp == head && temp == tail) {

            head = null;
            tail = null;
            current = null;

        }

        // Jika Node yang dihapus adalah head
        else if (temp == head) {

            head = temp.next;
            head.prev = null;

            if (current == temp) {
                current = head;
            }

        }

        // Jika Node yang dihapus adalah tail
        else if (temp == tail) {

            tail = temp.prev;
            tail.next = null;

            if (current == temp) {
                current = tail;
            }

        }

        // Jika Node berada di tengah
        else {

            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;

            if (current == temp) {
                current = temp.next;
            }
        }

        System.out.println("Buku dengan ID " + id + " berhasil dihapus.");
    }

   

   

public Node next() {

   
    if (current == null) {
        System.out.println("Reading list masih kosong.");
        return null;
    }


    if (current.next == null) {
        System.out.println("Sudah berada di buku terakhir.");
        return current;
    }


    current = current.next;

    return current;
}

public Node previous() {

  
    if (current == null) {
        System.out.println("Reading list masih kosong.");
        return null;
    }

    // Jika current sudah berada di buku pertama
    if (current.prev == null) {
        System.out.println("Sudah berada di buku pertama.");
        return current;
    }

    current = current.prev;

    return current;
}
}