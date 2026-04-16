package net.nieadni.hyliacraft.client.render;

import net.minecraft.client.render.model.json.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import org.joml.Vector3f;

import java.util.List;
import java.util.Map;

public enum CustomDirtModel {

    DIRT(Identifier.ofVanilla("block/dirt")) {
        @Override
        public void modifyElements(List<ModelElement> elements) {
            elements.clear();

            // We trust that the texture will already be provided; other mods are free to change it
            String texture = "#all";
            ModelElementTexture textureData = new ModelElementTexture(new float[]{0, 0, 16, 16}, 0);

            // Add a thin cuboid for each face of the block
            for (Direction direction : Direction.values()) {
                // This element will be on the {direction} face
                // Get bounds of the element
                Vector3f from = new Vector3f(0, 0, 0);
                Vector3f to = new Vector3f(16, 16, 16);
                int axis = direction.getAxis().ordinal();
                if (direction.getDirection() == Direction.AxisDirection.POSITIVE) {
                    from.setComponent(axis, 15.998f);
                } else {
                    to.setComponent(axis, 0.002f);
                }

                // Make faces
                ModelElementFace face = new ModelElementFace(
                        direction,
                        -1,
                        texture,
                        textureData
                );
                Map<Direction, ModelElementFace> faces = Map.of(
                        direction, face,
                        direction.getOpposite(), face
                );

                ModelElement element = new ModelElement(from, to, faces, null, true);
                elements.add(element);
            }
        }
    },
    GRASS_BLOCK(Identifier.ofVanilla("block/grass_block")) {
        @Override
        public void modifyElements(List<ModelElement> elements) {
            elements.clear();

            String overlayTexture = "#overlay";
            ModelElementTexture textureData = new ModelElementTexture(new float[]{0, 0, 16, 16}, 0);

            // Add two thin cuboids on each face of the block (texture and overlay)
            for (Direction direction : Direction.values()) {
                // This element will be on the {direction} face
                // Get bounds of the element
                Vector3f from = new Vector3f(0, 0, 0);
                Vector3f to = new Vector3f(16, 16, 16);
                int axis = direction.getAxis().ordinal();
                if (direction.getDirection() == Direction.AxisDirection.POSITIVE) {
                    from.setComponent(axis, 15.998f);
                } else {
                    to.setComponent(axis, 0.002f);
                }

                // Make the texture element
                // We trust that the textures will already be provided - other mods are free to change them
                String texture = switch (direction) {
                    case UP -> "#top";
                    case DOWN -> "#bottom";
                    default -> "#side";
                };
                int tintIndex = direction == Direction.UP ? 0 : -1;
                ModelElementFace textureFace = new ModelElementFace(
                        direction,
                        tintIndex,
                        texture,
                        textureData
                );
                Map<Direction, ModelElementFace> textureFaces = Map.of(
                        direction, textureFace,
                        direction.getOpposite(), textureFace
                );
                ModelElement textureElement = new ModelElement(from, to, textureFaces, null, true);
                elements.add(textureElement);

                // Make the overlay element (sides only)
                if (direction.getAxis() != Direction.Axis.Y) {
                    ModelElementFace overlayFace = new ModelElementFace(
                            direction,
                            0,
                            overlayTexture,
                            textureData
                    );
                    Map<Direction, ModelElementFace> overlayFaces = Map.of(
                            direction, overlayFace,
                            direction.getOpposite(), overlayFace
                    );
                    ModelElement overlayElement = new ModelElement(from, to, overlayFaces, null, true);
                    elements.add(overlayElement);
                }
            }
        }
    };

    public final Identifier id;

    CustomDirtModel(Identifier id) {
        this.id = id;
    }

    public abstract void modifyElements(List<ModelElement> elements);

    public static void modifyModel(Identifier id, JsonUnbakedModel model) {
        List<ModelElement> elements = model.elements;
        for (CustomDirtModel modifier : CustomDirtModel.values()) {
            if (id.equals(modifier.id)) {
                modifier.modifyElements(elements);
                break;
            }
        }
    }
}
