package image.submisson.demo.file.hash;

import image.submisson.demo.PojaGenerated;

@PojaGenerated
public record FileHash(FileHashAlgorithm algorithm, String value) {}
