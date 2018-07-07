package br.com.beepe.beepepro.utilitario;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Imagem implements Serializable
{
	public Imagem()
	{
	}
	public ObjectOutputStream Serealiza(Bitmap bitmap) throws IOException
	{
		ObjectOutputStream out	= null;

		ByteArrayOutputStream byteStream	= new ByteArrayOutputStream();
		bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteStream);
		byte arrayByte[]									= byteStream.toByteArray();
		out.write(arrayByte, 0, arrayByte.length);

		return out;
	}
	public Bitmap Desserealiza(ObjectInputStream imagem) throws IOException
	{
		ByteArrayOutputStream byteStream	= new ByteArrayOutputStream();
		byte arrayByte[];
		int b;

		while((b = imagem.read()) != -1)
		{
			byteStream.write(b);
		}

		arrayByte = byteStream.toByteArray();

		return BitmapFactory.decodeByteArray(arrayByte, 0, arrayByte.length);
	}
	public Bitmap Desserealiza(String imagem)
	{
		byte[] bytes	= Base64.decode(imagem, Base64.DEFAULT);
		Bitmap bitmap	= BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
		return bitmap;
	}
}

