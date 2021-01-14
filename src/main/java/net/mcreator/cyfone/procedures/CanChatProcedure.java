package net.mcreator.cyfone.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.ServerPlayerEntity;

import net.mcreator.cyfone.CyfoneModVariables;
import net.mcreator.cyfone.CyfoneModElements;

import java.util.Map;
import java.util.HashMap;

@CyfoneModElements.ModElement.Tag
public class CanChatProcedure extends CyfoneModElements.ModElement {
	public CanChatProcedure(CyfoneModElements instance) {
		super(instance, 6);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure CanChat!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((CyfoneModVariables.MapVariables.get(world).canchat) == 1)) {
			if (dependencies.get("event") != null) {
				Object _obj = dependencies.get("event");
				if (_obj instanceof Event) {
					Event _evt = (Event) _obj;
					if (_evt.isCancelable())
						_evt.setCanceled(true);
				}
			}
		}
	}

	@SubscribeEvent
	public void onChat(ServerChatEvent event) {
		ServerPlayerEntity entity = event.getPlayer();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("text", event.getMessage());
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
