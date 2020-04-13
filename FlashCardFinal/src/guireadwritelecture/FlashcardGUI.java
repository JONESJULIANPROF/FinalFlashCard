
package GuiReadWriteLecture;

import guireadwritelecture.Flashcard;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FlashcardGUI extends javax.swing.JFrame {

    FileSystem fs;
    Path pathToFile;
    InputStream fileIn = null;
    BufferedReader fileReader;
    ArrayList<Flashcard> cardList = new ArrayList<Flashcard>();
    ArrayList<Flashcard> reviewCardList = new ArrayList<Flashcard>();
    int index = 0;
    int reviewIndex = 0;
    boolean toggle = false;
    boolean reviewToggle = false;

    public void showRecord() {
        if (reviewToggle == true) {
            this.setTitle("Review card # " + (reviewIndex + 1) + " of " + reviewCardList.size());
        } else {
            this.setTitle("Record # " + (index + 1) + " of " + cardList.size());
        }

    }

    /**
     * Creates new form CompanyGUI
     */


    public void writeToDisk() {
        String fileName = "c:\\data\\FlashCards.txt";
        String outputLine = "";
        File outFile = new File(fileName);

        try {
            FileWriter fileWrite = new FileWriter(outFile);

            for (int x = 0; x < cardList.size(); x++) {
                outputLine = String.format("%d#%s#%s\n", cardList.get(x).getId(),
                        cardList.get(x).getTerm(), cardList.get(x).getDef());
                fileWrite.write(outputLine);
            }//end of for
            fileWrite.flush();
            fileWrite.close();
        } catch (IOException ex) {
            //Logger.getLogger(CompanyGUI.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Cannot write card\n" + ex.getMessage(), "FileIO Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public FlashcardGUI() {
        initComponents();
        
        reviewButton.setBackground(Color.yellow);
        updateButton.setBackground(Color.green);
        newFlashcardButton.setBackground(Color.green);
        markButton.setBackground(Color.green);
        fs = FileSystems.getDefault();
        pathToFile = fs.getPath("c:\\data\\FlashCards.txt");
        Flashcard aCard;
        String line = "";

        try {
            fileIn = Files.newInputStream(pathToFile);
            fileReader = new BufferedReader(new InputStreamReader(fileIn));
            //read the file on line at a time

            while ((line = fileReader.readLine()) != null) {
                String records[] = line.split("#");
                aCard = new Flashcard();

                try {
                    aCard.setId(Integer.parseInt(records[0]));
                    aCard.setTerm(records[1]);
                    aCard.setDef(records[2]);

                    cardList.add(aCard);
                } catch (NumberFormatException numberFormatException) {
                    //ignore lines with int id errors

                }//end of inner try

            }//end of while

            //JOptionPane.showMessageDialog(this, "Records read " + contactList.size());
            fileIn.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Cannot open card\n" + ex.getMessage());
            System.exit(1);
        }
        outputLabel.setText(cardList.get(index).getTerm());
        toggle = true;
        showRecord();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        lastButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        outputLabel = new javax.swing.JLabel();
        newTermField = new javax.swing.JTextField();
        newDefField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        newFlashcardButton = new javax.swing.JButton();
        markButton = new javax.swing.JButton();
        reviewButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Record # ");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        firstButton.setText("|<");
        firstButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstButtonActionPerformed(evt);
            }
        });

        prevButton.setText("<");
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        nextButton.setText(">");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        lastButton.setText(">|");
        lastButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        outputLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        outputLabel.setText("Term");
        outputLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                outputLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(outputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        newTermField.setText("Term");

        newDefField.setText("Definition");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        newFlashcardButton.setText("New Card");
        newFlashcardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFlashcardButtonActionPerformed(evt);
            }
        });

        markButton.setText("Mark for review");
        markButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                markButtonActionPerformed(evt);
            }
        });

        reviewButton.setText("Review");
        reviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reviewButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(newTermField)
                    .addComponent(newDefField)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(markButton, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reviewButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newFlashcardButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(170, 170, 170))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(firstButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(prevButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lastButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newTermField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newDefField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newFlashcardButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reviewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(markButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstButton)
                    .addComponent(prevButton)
                    .addComponent(nextButton)
                    .addComponent(lastButton)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:

        writeToDisk(); //save on exit
    }//GEN-LAST:event_formWindowClosing

    private void lastButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastButtonActionPerformed
        // TODO add your handling code here:
        if (reviewToggle == true) {

            reviewIndex = reviewCardList.size() -1 ;
            showRecord();
            outputLabel.setText(reviewCardList.get(reviewIndex).getTerm());
            toggle = true;
        } else {


            index = cardList.size() -1 ;
            outputLabel.setText(cardList.get(index).getTerm());
            toggle = true;
            showRecord();
        }

    }//GEN-LAST:event_lastButtonActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        if (reviewToggle == true) {
            if (reviewIndex < reviewCardList.size() - 1) {
                reviewIndex++;
                showRecord();
            outputLabel.setText(reviewCardList.get(reviewIndex).getTerm());
            toggle = true;
            }
        } else {

            if (index < cardList.size() - 1) {
                index++;
                showRecord();
                outputLabel.setText(cardList.get(index).getTerm());
                toggle = true;
            }
        }

    }//GEN-LAST:event_nextButtonActionPerformed

    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
        // TODO add your handling code here:
        if (reviewToggle == true) {
            if (reviewIndex > 0) {
                reviewIndex--;
                showRecord();
            outputLabel.setText(reviewCardList.get(reviewIndex).getTerm());
            toggle = true;

            }
        } else {

            if (index > 0) {
                index--;
                showRecord();
                outputLabel.setText(cardList.get(index).getTerm());
                toggle = true;
            }
        }

    }//GEN-LAST:event_prevButtonActionPerformed

    private void firstButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstButtonActionPerformed
        // TODO add your handling code here:
        if (reviewToggle == true) {
            outputLabel.setText(reviewCardList.get(reviewIndex).getTerm());
            toggle = true;
            reviewIndex = 0;
            showRecord();
            outputLabel.setText(reviewCardList.get(reviewIndex).getTerm());
            toggle = true;
        } else {

            index = 0;
            showRecord();
            outputLabel.setText(cardList.get(index).getTerm());
            toggle = true;
        }

    }//GEN-LAST:event_firstButtonActionPerformed

    private void outputLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_outputLabelMouseClicked
        // TODO add your handling code here:

        if (reviewToggle == true) {
            if (toggle == true) {
                outputLabel.setText(reviewCardList.get(reviewIndex).getDef());
                toggle = false;
            } else {
                outputLabel.setText(reviewCardList.get(reviewIndex).getTerm());
                toggle = true;
            }
        } else {
            if (toggle == true) {
                outputLabel.setText(cardList.get(index).getDef());
                toggle = false;
            } else {
                outputLabel.setText(cardList.get(index).getTerm());
                toggle = true;
            }
        }

    }//GEN-LAST:event_outputLabelMouseClicked

    private void reviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reviewButtonActionPerformed
        if(reviewCardList.size() <1){
            
        }else{
        
        if (reviewToggle == true) {
            reviewToggle = false;
            reviewButton.setBackground(Color.yellow);
            updateButton.setBackground(Color.green);
            newFlashcardButton.setBackground(Color.green);
            markButton.setBackground(Color.green);
            showRecord();
            outputLabel.setText(cardList.get(index).getTerm());
            toggle = true;
            
        } else {
            reviewToggle = true;
            reviewButton.setBackground(Color.green);
            updateButton.setBackground(Color.red);
            newFlashcardButton.setBackground(Color.red);
            markButton.setBackground(Color.red);
            showRecord();
            outputLabel.setText(reviewCardList.get(reviewIndex).getTerm());
            toggle = true;
            
        }
    }//GEN-LAST:event_reviewButtonActionPerformed
    }
    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        if (reviewToggle == true) {

        } else {
            showRecord();
            cardList.get(index).setTerm(newTermField.getText());
            cardList.get(index).setId(index);
            cardList.get(index).setDef(newDefField.getText());
            outputLabel.setText(cardList.get(index).getTerm());
            toggle = true;
        }


    }//GEN-LAST:event_updateButtonActionPerformed

    private void markButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_markButtonActionPerformed
        if (reviewToggle == true) {

        } else {
            showRecord();
            reviewCardList.add(cardList.get(index));
        }


    }//GEN-LAST:event_markButtonActionPerformed

    private void newFlashcardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFlashcardButtonActionPerformed
        if (reviewToggle == true) {

        } else {
            Flashcard aCard = new Flashcard();

            aCard.setId((cardList.size()));
            aCard.setTerm(newTermField.getText());
            aCard.setDef(newDefField.getText());

            cardList.add(aCard);

            showRecord();
        }
    }//GEN-LAST:event_newFlashcardButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        writeToDisk();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FlashcardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FlashcardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FlashcardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FlashcardGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FlashcardGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton firstButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton lastButton;
    private javax.swing.JButton markButton;
    private javax.swing.JTextField newDefField;
    private javax.swing.JButton newFlashcardButton;
    private javax.swing.JTextField newTermField;
    private javax.swing.JButton nextButton;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton reviewButton;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
