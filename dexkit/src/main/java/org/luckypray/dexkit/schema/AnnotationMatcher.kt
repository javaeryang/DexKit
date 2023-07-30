// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class AnnotationMatcher : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : AnnotationMatcher {
        __init(_i, _bb)
        return this
    }
    val typeClass : ClassMatcher? get() = typeClass(ClassMatcher())
    fun typeClass(obj: ClassMatcher) : ClassMatcher? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val targetElementTypes : TargetElementTypesMatcher? get() = targetElementTypes(TargetElementTypesMatcher())
    fun targetElementTypes(obj: TargetElementTypesMatcher) : TargetElementTypesMatcher? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val policy : Byte
        get() {
            val o = __offset(8)
            return if(o != 0) bb.get(o + bb_pos) else 0
        }
    fun mutatePolicy(policy: Byte) : Boolean {
        val o = __offset(8)
        return if (o != 0) {
            bb.put(o + bb_pos, policy)
            true
        } else {
            false
        }
    }
    val annotations : AnnotationsMatcher? get() = annotations(AnnotationsMatcher())
    fun annotations(obj: AnnotationsMatcher) : AnnotationsMatcher? {
        val o = __offset(10)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsAnnotationMatcher(_bb: ByteBuffer): AnnotationMatcher = getRootAsAnnotationMatcher(_bb, AnnotationMatcher())
        fun getRootAsAnnotationMatcher(_bb: ByteBuffer, obj: AnnotationMatcher): AnnotationMatcher {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createAnnotationMatcher(builder: FlatBufferBuilder, typeClassOffset: Int, targetElementTypesOffset: Int, policy: Byte, annotationsOffset: Int) : Int {
            builder.startTable(4)
            addAnnotations(builder, annotationsOffset)
            addTargetElementTypes(builder, targetElementTypesOffset)
            addTypeClass(builder, typeClassOffset)
            addPolicy(builder, policy)
            return endAnnotationMatcher(builder)
        }
        fun startAnnotationMatcher(builder: FlatBufferBuilder) = builder.startTable(4)
        fun addTypeClass(builder: FlatBufferBuilder, typeClass: Int) = builder.addOffset(0, typeClass, 0)
        fun addTargetElementTypes(builder: FlatBufferBuilder, targetElementTypes: Int) = builder.addOffset(1, targetElementTypes, 0)
        fun addPolicy(builder: FlatBufferBuilder, policy: Byte) = builder.addByte(2, policy, 0)
        fun addAnnotations(builder: FlatBufferBuilder, annotations: Int) = builder.addOffset(3, annotations, 0)
        fun endAnnotationMatcher(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
