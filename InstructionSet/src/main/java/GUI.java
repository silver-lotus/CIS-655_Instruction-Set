import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI {

    static JFrame frame = new JFrame("Instruction Set");
    static JPanel registers = new JPanel();
    static JPanel instructions = new JPanel();
    static JPanel memory = new JPanel();
    static JTextField instructionTextField = new JTextField(20);
    static JButton runInstructionButton = new JButton("Run Instruction");
    static JTextArea registerTextArea = new JTextArea(10, 30);
    static JTextArea memoryTextArea = new JTextArea(10, 30);

    public static void runGUI() {
        setFrame();
        setPanels();
    }

    private static void setFrame() {
        frame.setSize(1200, 800);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void setPanels() {
        setRegisterPanel();
        setInstructionPanel();
        setMemoryPanel();
    }

    private static void setRegisterPanel() {
        registers.add(new JLabel("Register Panel"));
        setRegisterTextArea();
        frame.getContentPane().add(registers, BorderLayout.WEST);
    }

    private static void setInstructionPanel() {
        instructions.add(new JLabel("Instruction Panel"));
        setInstructionTextField();
        setRunInstructionButton();
        frame.getContentPane().add(instructions, BorderLayout.CENTER);
    }

    private static void setMemoryPanel() {
        memory.add(new JLabel("Memory Panel"));
        setMemoryTextArea();
        frame.getContentPane().add(memory, BorderLayout.EAST);
    }

    private static void setRegisterTextArea() {
        registerTextArea.setText("text\ntext\ntext");
        registerTextArea.setEditable(false);
        registers.add(registerTextArea);
    }

    private static void setMemoryTextArea() {
        memoryTextArea.setText("text\ntext\ntext");
        memoryTextArea.setEditable(false);
        memory.add(memoryTextArea);
    }

    private static void setInstructionTextField() {
        instructions.add(instructionTextField);
        instructionTextField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) { }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    runInstruction();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) { }
        });
    }

    private static void setRunInstructionButton() {
        instructions.add(runInstructionButton);
        runInstructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runInstruction();
            }
        });
    }

    private static void runInstruction() {
        String instruction = instructionTextField.getText();
        // TODO: run instruction
        instructionTextField.setText("");
    }

}