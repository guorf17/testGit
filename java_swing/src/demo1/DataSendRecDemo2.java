package demo1;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DataSendRecDemo2 extends JFrame {

    private static final long serialVersionUID = 1L;

    private String[] labelName = {"name",
                                  "address",
                                  "ID",
                                  "param4",
                                  "param5",
                                  "param6",
                                  "param7",
                                  "param8",
                                  "param9"
                                  };

    private String[] textValue = {"tp",
                                  "xxxx",
                                  "1234",
                                  "www",
                                  "00001",
                                  "0123456789",
                                  "abc",
                                  "123",
                                  "20120917090233"
                                  };

    private JPanel jPanel;
    private JLabel jLabel;
    private JTextField jTextField;
    private JButton jButton;
    private String[] textValueTemp = textValue;
    
    public DataSendRecDemo2() {
        super();
        initFrame();
    }
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DataSendRecDemo2 srDemon = new DataSendRecDemo2();
                srDemon.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                srDemon.setVisible(true);
                srDemon.setLocation(100, 100);
                srDemon.setResizable(false);
            }
        });
    }
    
    public void initFrame() {
        setTitle("The demon of the iphone send data");
        setSize(800, 600);
        
        jPanel = new JPanel();
        jPanel.setBorder((BorderFactory.createTitledBorder("Send type struct by key : value")));
        jPanel.setLayout(new GridLayout(labelName.length, 2));
        
        // 动态追加JLabel和JTextField
        for (int i = 0; i < labelName.length; i++) {
            jLabel = new JLabel(labelName[i], SwingConstants.LEFT);
            jLabel.setFont(new Font("ITALIC", 0, 14));
            
            jTextField = new JTextField(textValue[i], SwingConstants.RIGHT);
            jTextField.setFont(new Font("Dialog", 0, 12));
            // 让动态追加的JLabel和JTextField相互匹配
            jTextField.setName(labelName[i]);
            
            // 给动态追加的JTextField绑定值变更事件
            jTextField.addFocusListener(new FocusListener() {
                String valChangedBef = "";
                String valChangedAft = "";
                String focusName = "";
                JTextField focusValue;
                
                @Override
                public void focusLost(FocusEvent e) {
                    focusValue = (JTextField) e.getComponent();
                    valChangedAft = focusValue.getText();
                    
                    if(!valChangedBef.equals(valChangedAft)){
                        focusName = e.getComponent().getName().toString();
                        
                        for (int j = 0; j < labelName.length; j++) {
                            if (focusName.equals(labelName[j])) {
                                textValueTemp[j] = valChangedAft;
                            }
                        }
                    }
                }
                
                @Override
                public void focusGained(FocusEvent e) {
                    focusValue = (JTextField)e.getComponent();
                    valChangedBef = focusValue.getText();
                }
            });
            
            jPanel.add(jLabel);
            jPanel.add(jTextField);
            add(jPanel, BorderLayout.CENTER);
        }
        
        JPanel panel = new JPanel();
        jButton = new JButton("Send　Data");
        
        jButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String sendDataStr = "";
                for (int k = 0; k < labelName.length; k++) {
                    sendDataStr += "'" + labelName[k] + "':'" + textValueTemp[k] + "',";
                }
                
                sendDataStr = "{" + sendDataStr.substring(0, sendDataStr.length() - 1) + "}";
                // 响应JButton事件，发送所有与JLabel一一对应的JTextField数据
                sendData(sendDataStr);
            }
        });

        panel.add(jButton);
        add(panel, BorderLayout.SOUTH);
        
        JPanel panelN = new JPanel();
        add(panelN, BorderLayout.NORTH);
        JPanel panelW = new JPanel();
        add(panelW, BorderLayout.WEST);
        JPanel panelE = new JPanel();
        add(panelE, BorderLayout.EAST);
        
        // 给JPanel追加垂直滚动条
        addScroll();
    }
    
    public void sendData(String sendData) {
        
        System.out.println("strMsgjson: " + sendData);
    }
    
    public void addScroll() {
        Container scrollPanel = getContentPane();
        JScrollPane jScrollPane = new JScrollPane(jPanel);
        
        scrollPanel.setPreferredSize(new Dimension(400, 280));
        scrollPanel.add(jScrollPane);
        scrollPanel.setVisible(true);
    }
}
