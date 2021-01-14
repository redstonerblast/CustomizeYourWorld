package net.mcreator.cyfone.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.cyfone.CyfoneModVariables;
import net.mcreator.cyfone.CyfoneModElements;

import java.util.Map;
import java.util.HashMap;

@CyfoneModElements.ModElement.Tag
public class CustomgameruleCommandExecutedProcedure extends CyfoneModElements.ModElement {
	public CustomgameruleCommandExecutedProcedure(CyfoneModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure CustomgameruleCommandExecuted!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				System.err.println("Failed to load dependency cmdparams for procedure CustomgameruleCommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CustomgameruleCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		IWorld world = (IWorld) dependencies.get("world");
		double booleanstate = 0;
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("1");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("true"))) {
			booleanstate = (double) 0;
		} else {
			booleanstate = (double) 1;
		}
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals("breakBlock"))) {
			CyfoneModVariables.MapVariables.get(world).blockbreak = (double) (booleanstate);
			CyfoneModVariables.MapVariables.get(world).syncData(world);
		} else {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("placeBlock"))) {
				CyfoneModVariables.MapVariables.get(world).placeblock = (double) (booleanstate);
				CyfoneModVariables.MapVariables.get(world).syncData(world);
			} else {
				if ((((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText())).equals("chat"))) {
					CyfoneModVariables.MapVariables.get(world).canchat = (double) (booleanstate);
					CyfoneModVariables.MapVariables.get(world).syncData(world);
				} else {
					if ((((new Object() {
						public String getText() {
							String param = (String) cmdparams.get("0");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText())).equals("canTrample"))) {
						CyfoneModVariables.MapVariables.get(world).farmtrample = (double) (booleanstate);
						CyfoneModVariables.MapVariables.get(world).syncData(world);
					} else {
						if ((((new Object() {
							public String getText() {
								String param = (String) cmdparams.get("0");
								if (param != null) {
									return param;
								}
								return "";
							}
						}.getText())).equals("canTame"))) {
							CyfoneModVariables.MapVariables.get(world).cantame = (double) (booleanstate);
							CyfoneModVariables.MapVariables.get(world).syncData(world);
						} else {
							if (entity instanceof PlayerEntity && !entity.world.isRemote) {
								((PlayerEntity) entity).sendStatusMessage(new StringTextComponent("Invalid Command Paramaters"), (false));
							}
						}
					}
				}
			}
		}
	}
}
