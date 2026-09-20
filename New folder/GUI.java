import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    JPanel inputPanel;
    JPanel currentPanel;
    JPanel navigationPanel;
    JPanel contentPanel;

    JTextField idField;
    JTextField titleField;
    JTextField authorField;

    JLabel currentIdLabel;
    JLabel currentTitleLabel;
    JLabel currentAuthorLabel;

    JButton addButton;
    JButton deleteButton;

    JButton previousButton;
    JButton nextButton;


    Doublelinkedlist list;


    public GUI() {

        setTitle("Library Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(350, 400);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));


        list = new Doublelinkedlist();

        inputPanel = new JPanel();
        currentPanel = new JPanel();
        navigationPanel = new JPanel();
        contentPanel = new JPanel();


        add(inputPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(navigationPanel, BorderLayout.SOUTH);


        inputPanel.setLayout(new BorderLayout(10, 10));

        inputPanel.setBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );


        JPanel formPanel = new JPanel();

        formPanel.setLayout(
            new GridLayout(3, 2, 10, 10)
        );


        // ID
        formPanel.add(new JLabel("ID Buku"));

        idField = new JTextField();
        formPanel.add(idField);


        // Judul
        formPanel.add(new JLabel("Judul"));

        titleField = new JTextField();
        formPanel.add(titleField);


        // Penulis
        formPanel.add(new JLabel("Penulis"));

        authorField = new JTextField();
        formPanel.add(authorField);


        inputPanel.add(
            formPanel,
            BorderLayout.CENTER
        );


        JPanel buttonPanel = new JPanel(
            new FlowLayout(
                FlowLayout.CENTER,
                10,
                5
            )
        );


        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
      

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
      

        inputPanel.add(
            buttonPanel,
            BorderLayout.SOUTH
        );

        contentPanel.setLayout(
            new BorderLayout(10, 10)
        );

        currentPanel.setLayout(
            new GridLayout(3, 2, 10, 10)
        );

        currentPanel.setBorder(
            BorderFactory.createTitledBorder(
                "Current Book"
            )
        );


        // ID
        currentPanel.add(
            new JLabel("ID Buku")
        );

        currentIdLabel = new JLabel("-");
        currentPanel.add(
            currentIdLabel
        );


        // Judul
        currentPanel.add(
            new JLabel("Judul")
        );

        currentTitleLabel = new JLabel("-");
        currentPanel.add(
            currentTitleLabel
        );


        // Penulis
        currentPanel.add(
            new JLabel("Penulis")
        );

        currentAuthorLabel = new JLabel("-");
        currentPanel.add(
            currentAuthorLabel
        );


        contentPanel.add(
            currentPanel,
            BorderLayout.NORTH
        );

        previousButton = new JButton(
            "← Previous"
        );

        nextButton = new JButton(
            "Next →"
        );


        navigationPanel.add(
            previousButton
        );

        navigationPanel.add(
            nextButton
        );



        addButton.addActionListener(e -> {

            String id = idField.getText();
            String title = titleField.getText();
            String author = authorField.getText();


            if (
                id.isEmpty() ||
                title.isEmpty() ||
                author.isEmpty()
            ) {

                JOptionPane.showMessageDialog(
                    this,
                    "Semua data buku harus diisi!"
                );

                return;
            }


            Book book = new Book(
                id,
                title,
                author
            );


            list.add(book);


            displayCurrentBook();

            clearInput();


            JOptionPane.showMessageDialog(
                this,
                "Buku berhasil ditambahkan!"
            );

        });


        deleteButton.addActionListener(e -> {

            String id = idField.getText();


            if (id.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Masukkan ID buku yang ingin dihapus!"
                );

                return;
            }


    


            list.delete(id);


            displayCurrentBook();

          
            clearInput();


            JOptionPane.showMessageDialog(
                this,
                "Buku berhasil dihapus!"
            );

        });

        previousButton.addActionListener(e -> {

            list.previous();

            displayCurrentBook();

        });

        nextButton.addActionListener(e -> {

            list.next();

            displayCurrentBook();

        });

        setVisible(true);
    }


    private void displayCurrentBook() {

        if (list.current == null) {

            currentIdLabel.setText("-");
            currentTitleLabel.setText("-");
            currentAuthorLabel.setText("-");

            return;
        }


        Book book = list.current.data;


        currentIdLabel.setText(
            book.id
        );

        currentTitleLabel.setText(
            book.title
        );

        currentAuthorLabel.setText(
            book.author
        );
    }


    private void clearInput() {

        idField.setText("");
        titleField.setText("");
        authorField.setText("");
    }
}