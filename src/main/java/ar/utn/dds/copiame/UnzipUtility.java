package ar.utn.dds.copiame;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnzipUtility {

	private static final int BUFFER_SIZE = 4096;

	public static void unzip(File zipFile, String destDirectory) throws IOException {

		FileInputStream inStream = new FileInputStream(zipFile);
		unzip(inStream, destDirectory);
	}

	public static void unzip(InputStream inStream, String destDirectory) throws IOException {
		File destDir = new File(destDirectory);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		try (ZipInputStream zipIn = new ZipInputStream(inStream)) {
			ZipEntry entry = zipIn.getNextEntry();
			while (entry != null) {
				String filePath = destDirectory + File.separator + entry.getName();
				if (!entry.isDirectory()) {
					extractFile(zipIn, filePath);
				}
				zipIn.closeEntry();
				entry = zipIn.getNextEntry();
			}
		}
	}

	private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
			byte[] bytesIn = new byte[BUFFER_SIZE];
			int read = 0;
			while ((read = zipIn.read(bytesIn)) != -1) {
				bos.write(bytesIn, 0, read);
			}
		}
	}
}