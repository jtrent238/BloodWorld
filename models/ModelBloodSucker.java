//Made with Blockbench
//Paste this code into your mod.

public static class ModelBloodSucker extends ModelBase {
	private final ModelRenderer bone;

	public ModelBloodSucker() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -8.0F, -8.0F, 5, 5,
				16, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 21, -6.0F, -7.0F, -7.0F, 13, 1,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 6, 5.0F, -8.0F, -8.0F, 3, 3, 3,
				0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -7.0F, -8.0F, -8.0F, 3, 3,
				3, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 23, 0.0F, -5.0F, -11.0F, 1, 1,
				4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 26, 26, -2.0F, -4.0F, -4.0F, 1, 4,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 22, 23, 2.0F, -4.0F, -4.0F, 1, 4,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 18, 23, 2.0F, -4.0F, -1.0F, 1, 4,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 14, 23, 2.0F, -4.0F, 2.0F, 1, 4,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 10, 23, 2.0F, -4.0F, 5.0F, 1, 4,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 12, 5, -2.0F, -4.0F, 5.0F, 1, 4,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 12, 0, -2.0F, -4.0F, 2.0F, 1, 4,
				1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 11, 11, -2.0F, -4.0F, -1.0F, 1, 4,
				1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		bone.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}