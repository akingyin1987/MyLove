/*
 * Copyright (c) 2016. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 * Email:akingyin@163.com
 * QQ:153865235
 */

package com.akingyin.librarys.utils;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;

/**
 * Created by Administrator on 2016/5/25.
 */

public class FileUtil {
    public static final String TAG = "FileUtil";
    private static final int IO_BUFFER_SIZE = 16384;

    public static boolean create(String absPath) {
        return create(absPath, false);
    }

    public static boolean create(String absPath, boolean force) {
        if (TextUtils.isEmpty(absPath)) {
            return false;
        }

        if (exists(absPath)) {
            return true;
        }

        String parentPath = getParent(absPath);
        mkdirs(parentPath, force);

        try {
            File file = new File(absPath);
            return file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean mkdirs(String absPath) {
        return mkdirs(absPath, false);
    }

    public static boolean mkdirs(String absPath, boolean force) {
        File file = new File(absPath);
        if (exists(absPath) && !isFolder(absPath)) {
            if (!force) {
                return false;
            } else {
                delete(file);
            }
        }
        try {
            file.mkdirs();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists(file);
    }

    public static boolean move(String srcPath, String dstPath) {
        return move(srcPath, dstPath, false);
    }

    public static boolean move(String srcPath, String dstPath, boolean force) {
        if (TextUtils.isEmpty(srcPath) || TextUtils.isEmpty(dstPath)) {
            return false;
        }

        if (!exists(srcPath)) {
            return false;
        }

        if (exists(dstPath)) {
            if (!force) {
                return false;
            } else {
                delete(dstPath);
            }
        }

        try {
            File srcFile = new File(srcPath);
            File dstFile = new File(dstPath);
            return srcFile.renameTo(dstFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean delete(String absPath) {
        if (TextUtils.isEmpty(absPath)) {
            return false;
        }

        File file = new File(absPath);
        return delete(file);
    }

    public static boolean delete(File file) {
        if (!exists(file)) {
            return true;
        }

        if (file.isFile()) {
            return file.delete();
        }

        boolean result = true;
        File files[] = file.listFiles();
        for (int index = 0; index < files.length; index++) {
            result |= delete(files[index]);
        }
        result |= file.delete();

        return result;
    }

    public static boolean exists(String absPath) {
        if (TextUtils.isEmpty(absPath)) {
            return false;
        }
        File file = new File(absPath);
        return exists(file);
    }

    public static boolean exists(File file) {
        return file == null ? false : file.exists();
    }

    public static boolean childOf(String childPath, String parentPath) {
        if (TextUtils.isEmpty(childPath) || TextUtils.isEmpty(parentPath)) {
            return false;
        }
        childPath = cleanPath(childPath);
        parentPath = cleanPath(parentPath);
        if (childPath.startsWith(parentPath + File.separator)) {
            return true;
        }
        return false;
    }

    public static int childCount(String absPath) {
        if (!exists(absPath)) {
            return 0;
        }
        File file = new File(absPath);
        File[] children = file.listFiles();
        if (children == null || children.length == 0) {
            return 0;
        }
        return children.length;
    }

    public static String cleanPath(String absPath) {
        if (TextUtils.isEmpty(absPath)) {
            return absPath;
        }
        try {
            File file = new File(absPath);
            absPath = file.getCanonicalPath();
        } catch (Exception e) {

        }
        return absPath;
    }

    public static long size(String absPath) {
        if (absPath == null) {
            return 0;
        }
        File file = new File(absPath);
        return size(file);
    }

    public static long size(File file) {
        if (!exists(file)) {
            return 0;
        }

        long length = 0;
        if (isFile(file)) {
            length = file.length();
            return length;
        }

        File files[] = file.listFiles();
        if (files == null || files.length == 0) {
            return length;
        }

        int size = files.length;
        for (int index = 0; index < size; index++) {
            File child = files[index];
            length += size(child);
        }
        return length;
    }

    public static boolean copy(String srcPath, String dstPath) {
        return copy(srcPath, dstPath, false);
    }

    public static boolean copy(String srcPath, String dstPath, boolean force) {
        if (TextUtils.isEmpty(srcPath) || TextUtils.isEmpty(dstPath)) {
            return false;
        }

        // check if copy source equals destination
        if (srcPath.equals(dstPath)) {
            return true;
        }

        // check if source file exists or is a directory
        if (!exists(srcPath) || !isFile(srcPath)) {
            return false;
        }

        // delete old content
        if (exists(dstPath)) {
            if (!force) {
                return false;
            } else {
                delete(dstPath);
            }
        }
        if (!create(dstPath)) {
            return false;
        }

        FileInputStream in = null;
        FileOutputStream out = null;

        // get streams
        try {
            in = new FileInputStream(srcPath);
            out = new FileOutputStream(dstPath);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return copy(in, out);
    }

    public static boolean copy(InputStream is, OutputStream os) {
        if (is == null || os == null) {
            return false;
        }

        try {
            byte[] buffer = new byte[IO_BUFFER_SIZE];
            int length;
            while ((length = is.read(buffer)) != -1) {
                os.write(buffer, 0, length);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                is.close();
            } catch (Exception ignore) {
            }
            try {
                os.close();
            } catch (Exception ignore) {

            }
        }
        return true;
    }

    public final static boolean isFile(String absPath) {
        boolean exists = exists(absPath);
        if (!exists) {
            return false;
        }

        File file = new File(absPath);
        return isFile(file);
    }

    public final static boolean isFile(File file) {
        return file == null ? false : file.isFile();
    }

    public final static boolean isFolder(String absPath) {
        boolean exists = exists(absPath);
        if (!exists) {
            return false;
        }

        File file = new File(absPath);
        return file.isDirectory();
    }

    public static boolean isSymlink(File file) {
        if (file == null) {
            return false;
        }

        boolean isSymlink = false;
        try {
            File canon = null;
            if (file.getParent() == null) {
                canon = file;
            } else {
                File canonDir = file.getParentFile().getCanonicalFile();
                canon = new File(canonDir, file.getName());
            }
            isSymlink = !canon.getCanonicalFile().equals(
                    canon.getAbsoluteFile());
        } catch (Exception e) {
        }
        return isSymlink;
    }

    public final static String getName(File file) {
        return file == null ? null : getName(file.getAbsolutePath());
    }

    public final static String getName(String absPath) {
        if (TextUtils.isEmpty(absPath)) {
            return absPath;
        }

        String fileName = null;
        int index = absPath.lastIndexOf("/");
        if (index >= 0 && index < (absPath.length() - 1)) {
            fileName = absPath.substring(index + 1, absPath.length());
        }
        return fileName;
    }

    public final static String getParent(File file) {
        return file == null ? null : file.getParent();
    }

    public final static String getParent(String absPath) {
        if (TextUtils.isEmpty(absPath)) {
            return null;
        }
        absPath = cleanPath(absPath);
        File file = new File(absPath);
        return getParent(file);
    }

    public static String getStem(File file) {
        return file == null ? null : getStem(file.getName());
    }

    public final static String getStem(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return null;
        }

        int index = fileName.lastIndexOf(".");
        if (index > 0) {
            return fileName.substring(0, index);
        } else {
            return "";
        }
    }

    public static String getExtension(File file) {
        return file == null ? null : getExtension(file.getName());
    }

    public static String getExtension(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return "";
        }

        int index = fileName.lastIndexOf('.');
        if (index < 0 || index >= (fileName.length() - 1)) {
            return "";
        }
        return fileName.substring(index + 1);
    }

    public static String getMimeType(File file) {
        if (file == null) {
            return "*/*";
        }
        String fileName = file.getName();
        return getMimeType(fileName);
    }

    public static String getMimeType(String fileName) {
        if (TextUtils.isEmpty(fileName)) {
            return "*/*";
        }
        String extension = getExtension(fileName);
        MimeTypeMap map = MimeTypeMap.getSingleton();
        String type = map.getMimeTypeFromExtension(extension);
        if (TextUtils.isEmpty(type)) {
            return "*/*";
        } else {
            return type;
        }
    }

    public static String fileSHA1(String absPath) {
        if (TextUtils.isEmpty(absPath)) {
            return null;
        }
        File file = new File(absPath);

        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        String fileSHA1 = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return null;
        }
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("SHA-1");
            byte[] buffer = new byte[IO_BUFFER_SIZE];
            int length = 0;
            while ((length = fis.read(buffer)) > 0) {
                messageDigest.update(buffer, 0, length);
            }
            fis.close();
            fileSHA1 = SecurityUtil.bytes2Hex(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(fileSHA1)) {
            fileSHA1 = fileSHA1.trim();
        }
        return fileSHA1;
    }

    /**
     * 把一个文件转成MD5加密
     * @param absPath
     * @return
     */
    public static String fileMD5(String absPath) {
        if (TextUtils.isEmpty(absPath)) {
            return null;
        }
        File file = new File(absPath);
        if (!file.exists() || file.isDirectory()) {
            return null;
        }
        String fileMD5 = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return null;
        }
        MessageDigest messageDigest;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[IO_BUFFER_SIZE];
            int length = 0;
            while ((length = fis.read(buffer)) > 0) {
                messageDigest.update(buffer, 0, length);
            }
            fis.close();
            fileMD5 = SecurityUtil.bytes2Hex(messageDigest.digest());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(fileMD5)) {
            fileMD5 = fileMD5.trim();
        }
        return fileMD5;
    }

    public static final boolean write(String absPath, String text) {
        if (!create(absPath, true)) {
            return false;
        }

        FileOutputStream fos = null;
        PrintWriter pw = null;
        try {
            fos = new FileOutputStream(absPath);
            pw = new PrintWriter(fos);
            pw.write(text);
            pw.flush();
        } catch (Exception e) {

        } finally {
            CloseUtil.close(pw);
            CloseUtil.close(fos);
        }

        return true;
    }

    public static final boolean write(String absPath, InputStream ips) {
        if (!create(absPath, true)) {
            return false;
        }

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(absPath);
            byte buffer[] = new byte[IO_BUFFER_SIZE];
            int count = ips.read(buffer);
            for (; count != -1;) {
                fos.write(buffer, 0, count);
                count = ips.read(buffer);
            }
            fos.flush();
        } catch (Exception e) {
            //
            return false;
        } finally {
            CloseUtil.close(fos);
        }

        return true;
    }





    public static final InputStream getStream(String absPath) {
        InputStream inputStream = null;

        try {
            inputStream = new FileInputStream(absPath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return inputStream;
    }
}
