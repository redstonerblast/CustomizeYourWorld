package net.mcreator.cyfone.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.entity.Entity;

import net.mcreator.cyfone.CyfoneModVariables;
import net.mcreator.cyfone.CyfoneModElements;

import java.util.Map;
import java.util.HashMap;

@CyfoneModElements.ModElement.Tag
public class PlaceBlockProcedure extends CyfoneModElements.ModElement {
	public PlaceBlockProcedure(CyfoneModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure PlaceBlock!");
			return;
		}
		IWorld world = (IWorld) dependencies.get("world");
		if (((CyfoneModVariables.MapVariables.get(world).placeblock) == 1)) {
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
	public void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		Entity entity = event.getEntity();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", (int) event.getPos().getX());
		dependencies.put("y", (int) event.getPos().getY());
		dependencies.put("z", (int) event.getPos().getZ());
		dependencies.put("px", entity.getPosX());
		dependencies.put("py", entity.getPosY());
		dependencies.put("pz", entity.getPosZ());
		dependencies.put("world", event.getWorld().getWorld());
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
