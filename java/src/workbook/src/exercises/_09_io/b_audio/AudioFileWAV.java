package exercises._09_io.b_audio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class AudioFileWAV {

	/** Write audio data to wav file.
	 * 
	 * @param filePath Full path and name of target file
	 * @param audioData Audio data to write to file
	 * @throws IOException 
	 */
	public static void writeWavFile(String filePath, AudioData audioData) throws IOException {		
		// Initialize stream to write to file
		File file = new File(filePath);
		FileOutputStream fileStream = new FileOutputStream(file);

		// Write header and audio samples to file
		long numberDataBytes = 2L * audioData.getNumberSamples();
		writeFileHeader(fileStream, audioData.getSamplingRateHz(), numberDataBytes);
		writeAudioData(fileStream, audioData.getSamples());

		// Cleanup
		fileStream.close();
	}

	/** Write wave file header to file.
	 * 
	 * @param fileStream Stream to write header to
	 * @param samplingRateHz Sampling rate in Hz
	 * @param numberDataBytes Number of bytes of audio data
	 * @throws IOException
	 */
	private static void writeFileHeader(FileOutputStream fileStream, int samplingRateHz, long numberDataBytes) throws IOException {
		int audioFormat = 1;
		int audioChannels = 1;
		int bytesPerSample = 2;		// Samples in audio data are of type short => 2 bytes
		int bitsPerSample = 16;
		int byteRate = bytesPerSample * samplingRateHz;
		long totalDataLength = numberDataBytes + 36;

		// Type and length information
		writeUTF8(fileStream, "RIFF");					// Chunk ID
		writeUInt32(fileStream, totalDataLength);
		writeUTF8(fileStream, "WAVE");    				// WAVE format

		// FMT subchunk
		writeUTF8(fileStream, "fmt ");					// Subchunk 1 ID
		writeUInt32(fileStream, 16);					// Subchunk 1 size	
		writeUInt16(fileStream, audioFormat);
		writeUInt16(fileStream, audioChannels);
		writeUInt32(fileStream, samplingRateHz);
		writeUInt32(fileStream, byteRate);
		writeUInt16(fileStream, audioChannels * bytesPerSample);	// Block align
		writeUInt16(fileStream, bitsPerSample);

		// Data subchunk		
		writeUTF8(fileStream, "data");					// Subchunk 2 ID
		writeUInt32(fileStream, numberDataBytes);	// Subchunk 2 size
	}

	/** Write audio samples to file.
	 * 
	 * @param fileStream Stream to write samples to
	 * @param samples Audio samples to write to file
	 * @throws IOException
	 */
	private static void writeAudioData(FileOutputStream fileStream, short[] samples) throws IOException {
		for (short sample : samples) {
			writeUInt16(fileStream, sample);
		}
	}

	/** Write a 2-byte unsigned integer to the file.
	 * <p>
	 * Byte order is reversed, i.e., the least significant byte is
	 * written first.
	 * 
	 * @param fileStream Stream to write to
	 * @param value Value to write
	 * @throws IOException
	 */
	private static void writeUInt16(FileOutputStream fileStream, int value) throws IOException {
		fileStream.write(new byte[] {
				(byte) (value & 0xff),
				(byte) ((value >> 8) & 0xff)
		});
	}
	
	/** Write a 4-byte unsigned integer to the file.
	 * <p>
	 * Byte order is reversed, i.e., the least significant byte is
	 * written first.
	 *  
	 * @param fileStream Stream to write to
	 * @param value Integer value to write (4-byte, unsigned)
	 * @throws IOException
	 */
	private static void writeUInt32(FileOutputStream fileStream, long value) throws IOException {
		fileStream.write(new byte[] {
				(byte) (value & 0xff),
				(byte) ((value >> 8) & 0xff),
				(byte) ((value >> 16) & 0xff),
				(byte) ((value >> 24) & 0xff)
		});
	}

	/** Write a string as 1-byte chars to the file.
	 * 
	 * @param fileStream Stream to write to
	 * @param chars Characters to write to the file
	 * @throws IOException
	 */
	private static void writeUTF8(FileOutputStream fileStream, String chars) throws IOException {
		fileStream.write(chars.getBytes(StandardCharsets.UTF_8));
	}
}
