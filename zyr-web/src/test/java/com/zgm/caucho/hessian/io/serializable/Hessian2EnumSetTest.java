package com.zgm.caucho.hessian.io.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.EnumSet;

import org.junit.Assert;
import org.junit.Test;

import com.alibaba.com.caucho.hessian.io.Hessian2Input;
import com.alibaba.com.caucho.hessian.io.Hessian2Output;

public class Hessian2EnumSetTest {

	@Test
	public void test_EnumSet() throws IOException {
		EnumSet typeH = EnumSet.of(Type.High);

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		Hessian2Output out = new Hessian2Output(bout);

		out.writeObject(typeH);
		out.flush();

		ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
		Hessian2Input input = new Hessian2Input(bin);
		EnumSet set = (EnumSet) input.readObject();

		Assert.assertTrue(Arrays.asList(set.toArray()).contains(Type.High));

		Assert.assertFalse(Arrays.asList(set.toArray()).contains(Type.Lower));
	}

	@Test
	public void test_Enum() throws IOException {
		Type[] types = new Type[] { Type.High, Type.Lower };

		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		Hessian2Output out = new Hessian2Output(bout);

		out.writeObject(types);
		out.flush();

		ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
		Hessian2Input input = new Hessian2Input(bin);
		Type[] set = (Type[]) input.readObject();

		Assert.assertTrue(Arrays.asList(set).contains(Type.High));

		Assert.assertFalse(Arrays.asList(set).contains(Type.Normal));
	}
}

enum Type {
	High, Normal, Lower
}
