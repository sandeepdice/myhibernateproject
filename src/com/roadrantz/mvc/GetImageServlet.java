/*
 * Created on May 21, 2004
 */
package com.roadrantz.mvc;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Hashtable;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Generated comment.
 *
 * @author meiwin.fu
 * @version 1.0
 * @since 1.0
 */
public class GetImageServlet extends HttpServlet
{

    private static final long serialVersionUID = 1L;

//    private static Log logger = Log.getInstance(BinaryCacheServlet.class, "servlet");

    private static Hashtable binaryCacheMap = new Hashtable();

    public void init() throws ServletException
    {
    }

    protected void doPost(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
    {
        doAction(arg0, arg1);
    }

    protected void doGet(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
    {
        doPost(arg0, arg1);
    }

    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException
    {
        doPost(arg0, arg1);
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response)
    {
    	
        String binaryId = request.getParameter("imgId");
        ServletContext sc = getServletContext(); 
        String filename = sc.getRealPath("WEB-INF/resources/Images/"+binaryId);
        System.out.println(filename);
     // Get the MIME type of the image 
        String mimeType = sc.getMimeType(filename); 
        if (mimeType == null) { sc.log("Could not get MIME type of "+filename); 
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); return; } 
        // Set content type resp.setContentType(mimeType); // Set content size 
        try{
        File file = new File(filename); 
        response.setContentLength((int)file.length()); // Open the file and output streams 
        FileInputStream in = new FileInputStream(file); 
        OutputStream out = response.getOutputStream(); // Copy the contents of the file to the output stream 
        byte[] buf = new byte[1024]; 
        int count = 0; 
        while ((count = in.read(buf)) >= 0) { out.write(buf, 0, count); } in.close(); out.close();
        }
        /*
        BinaryDataView binaryView = null;
        try
        {
            try
            {
                if (!binaryCacheMap.containsKey(binaryId))
                {
                    SystemManagerExt sysMgr = (SystemManagerExt) BusinessLogicFactory.getInstance().getBusinessLogic(
                            IListManager.SYSTEM_MANAGER);
                    binaryView = sysMgr.getBinaryData(new Long(binaryId).longValue());
                    if (binaryView != null)
                    {
                        binaryCacheMap.put(binaryId, binaryView);
                    }
                }
                binaryView = (BinaryDataView) binaryCacheMap.get(binaryId);
            }
            catch (GenericManagerException gme)
            {
                logger.error(gme.getMessage(), gme, null, null);
            }
            byte[] data = new byte[0];
            String contentType = "application/octet-stream";
            if (binaryView != null)
            {
                contentType = binaryView.getMimeType();

                InputStream is = binaryView.getBinaryData();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[10 * 1024];
                int nread = 0;
                while ((nread = is.read(buffer)) != -1)
                {
                    baos.write(buffer, 0, nread);
                }
                is.reset();
                is.close();
                baos.flush();
                data = baos.toByteArray();
                baos.close();
            }
            response.setContentType(contentType);
            response.setContentLength(data.length);
            OutputStream os = response.getOutputStream();
            os.write(data, 0, data.length);
            os.flush();
            os.close();
        }*/
        catch (Exception e)
        {
//            logger.error(e.getMessage(), e, null, null);
        }
    }

}
