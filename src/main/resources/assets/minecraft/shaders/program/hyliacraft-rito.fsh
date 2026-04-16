#version 150

uniform sampler2D DiffuseSampler;

in vec2 texCoord;

out vec4 fragColor;

void main(){
    vec4 diffuseColor = texture(DiffuseSampler, texCoord);
    float brightness = clamp(dot(diffuseColor, vec4(0.5, 0.3, 0.1, 0)) + 0.4, 0, 1);
    vec4 invertColor = brightness * diffuseColor;
    fragColor = vec4(invertColor.rgb, 1.0);
}
