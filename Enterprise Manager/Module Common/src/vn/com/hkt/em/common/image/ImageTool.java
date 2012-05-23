/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.image;

import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;

/**
 * Tool thực hiện xử lý ảnh
 * @author BinLe
 */
public class ImageTool {

    /**
     * Lấy ảnh icon từ máy tính
     * @return 
     */
    public ImageIcon getImage() {
        JDialog dialog = new JDialog();
        dialog.setModal(true);
        FileDialog fd = new FileDialog(dialog);
        fd.setVisible(true);
        String filePath = fd.getFile();
        String directory = fd.getDirectory();
        if (filePath == null || directory == null) {
            return null;
        }
        try {           
            return new ImageIcon(directory + filePath);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * Thuwch hiện thay đổi kích thước của ảnh theo kick thước truyền vào
     * @param image :ImageIcon ảnh truyền vào
     * @param dimension:Dimension kích thước
     * @return  
     * Trả về ảnh đã thay đổi kích thước
     */
    public ImageIcon resize(ImageIcon imageIcon, Dimension dimension) {        
        Image img = imageIcon.getImage();
        Image newimg = img.getScaledInstance(dimension.width, dimension.height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newimg);
    }
    /**
     * conver ảnh Image sang dạng mảng byte
     * @param image:Image dữu liệu ảnh truyền vào
     * @return : mảng byte của ảnh
     */
    public byte[] convertImage2ByteArray(Image image) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.drawImage(image, 0, 0, null);
            ImageIO.write(bi, "JPEG", baos);
        } catch (IOException ex) {
        }
        return baos.toByteArray();
    }
}
