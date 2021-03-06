package org.lwjgl.opengl;

import java.nio.FloatBuffer;

import org.mini.nanovg.Gutil;

public class GL20 extends GL11 {
	public static int glGetUniformLocation(int program, CharSequence uniformName) {
		return glGetUniformLocation(program, uniformName.toString().getBytes());
	}

	public static int glGetProgrami(int id, int glLinkStatus) {
		int[] ret = {0};
		glGetProgramiv(id, glLinkStatus, ret, 0);
		return ret[0];
	}

	public static void glBindAttribLocation(int id, int i, CharSequence string) {
		glBindAttribLocation(id, i, string.toString().getBytes());
	}

	public static String glGetProgramInfoLog(int id, int i) {
		int[] return_val = {0};
        glGetProgramiv(id, GL_INFO_LOG_LENGTH, return_val, 0);
        byte[] szLog = new byte[return_val[0] + 1];
        glGetProgramInfoLog(id, szLog.length, return_val, 0, szLog);
        return new String(szLog, 0, return_val[0]);
	}

	public static void glShaderSource(int id, CharSequence source) {
		glShaderSource(id, 1, new byte[][]{Gutil.toUtf8(source.toString())}, null, 0);
	}

	public static int glGetShaderi(int id, int glCompileStatus) {
        int[] return_val = {0};
        glGetShaderiv(id, glCompileStatus, return_val, 0);
        
        return return_val[0];
	}

	public static String glGetShaderInfoLog(int id, int i) {
		int[] return_val = {0};
        glGetShaderiv(id, GL_INFO_LOG_LENGTH, return_val, 0);
        byte[] szLog = new byte[return_val[0] + 1];
        glGetShaderInfoLog(id, szLog.length, return_val, 0, szLog);
        return new String(szLog, 0, return_val[0]);
	}
	
	public static void glUniformMatrix1fv(int location, boolean b, FloatBuffer data) {
		glUniform1fv(location, b?GL_TRUE:GL_FALSE, data.array(), data.arrayOffset());
	}
	
	public static void glUniformMatrix2fv(int location, boolean b, FloatBuffer data) {
		glUniform2fv(location, b?GL_TRUE:GL_FALSE, data.array(), data.arrayOffset());
	}
	
	public static void glUniformMatrix3fv(int location, boolean b, FloatBuffer data) {
		glUniform3fv(location, b?GL_TRUE:GL_FALSE, data.array(), data.arrayOffset());
	}
	
	public static void glUniformMatrix4fv(int location, boolean b, FloatBuffer data) {
		glUniform4fv(location, b?GL_TRUE:GL_FALSE, data.array(), data.arrayOffset());
	}
	
	public static void glUniform1fv(int location, float[] data) {
		glUniform1fv(location, data.length, data, 0);
	}
	
	public static void glUniform2fv(int location, float[] data) {
		glUniform2fv(location, data.length, data, 0);
	}
	
	public static void glUniform3fv(int location, float[] data) {
		glUniform3fv(location, data.length, data, 0);
	}
	
	public static void glUniform4fv(int location, float[] data) {
		glUniform4fv(location, data.length, data, 0);
	}
	
	public static void glVertexAttribPointer(int index, int len, int type, boolean normalized, int size, int offset) {
		glVertexAttribPointer(index, len, type, normalized?GL_TRUE:GL_FALSE, size, null, offset);
	}
}
