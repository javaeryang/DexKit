// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.Constants
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.Table
import java.nio.ByteBuffer
import java.nio.ByteOrder

@Suppress("unused")
class FieldMatcher : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : FieldMatcher {
        __init(_i, _bb)
        return this
    }
    val accessFlags : AccessFlagsMatcher? get() = accessFlags(AccessFlagsMatcher())
    fun accessFlags(obj: AccessFlagsMatcher) : AccessFlagsMatcher? {
        val o = __offset(4)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val declaringClass : ClassMatcher? get() = declaringClass(ClassMatcher())
    fun declaringClass(obj: ClassMatcher) : ClassMatcher? {
        val o = __offset(6)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val typeClass : ClassMatcher? get() = typeClass(ClassMatcher())
    fun typeClass(obj: ClassMatcher) : ClassMatcher? {
        val o = __offset(8)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
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
    val getMethods : MethodsMatcher? get() = getMethods(MethodsMatcher())
    fun getMethods(obj: MethodsMatcher) : MethodsMatcher? {
        val o = __offset(12)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    val putMethods : MethodsMatcher? get() = putMethods(MethodsMatcher())
    fun putMethods(obj: MethodsMatcher) : MethodsMatcher? {
        val o = __offset(14)
        return if (o != 0) {
            obj.__assign(__indirect(o + bb_pos), bb)
        } else {
            null
        }
    }
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsFieldMatcher(_bb: ByteBuffer): FieldMatcher = getRootAsFieldMatcher(_bb, FieldMatcher())
        fun getRootAsFieldMatcher(_bb: ByteBuffer, obj: FieldMatcher): FieldMatcher {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createFieldMatcher(builder: FlatBufferBuilder, accessFlagsOffset: Int, declaringClassOffset: Int, typeClassOffset: Int, annotationsOffset: Int, getMethodsOffset: Int, putMethodsOffset: Int) : Int {
            builder.startTable(6)
            addPutMethods(builder, putMethodsOffset)
            addGetMethods(builder, getMethodsOffset)
            addAnnotations(builder, annotationsOffset)
            addTypeClass(builder, typeClassOffset)
            addDeclaringClass(builder, declaringClassOffset)
            addAccessFlags(builder, accessFlagsOffset)
            return endFieldMatcher(builder)
        }
        fun startFieldMatcher(builder: FlatBufferBuilder) = builder.startTable(6)
        fun addAccessFlags(builder: FlatBufferBuilder, accessFlags: Int) = builder.addOffset(0, accessFlags, 0)
        fun addDeclaringClass(builder: FlatBufferBuilder, declaringClass: Int) = builder.addOffset(1, declaringClass, 0)
        fun addTypeClass(builder: FlatBufferBuilder, typeClass: Int) = builder.addOffset(2, typeClass, 0)
        fun addAnnotations(builder: FlatBufferBuilder, annotations: Int) = builder.addOffset(3, annotations, 0)
        fun addGetMethods(builder: FlatBufferBuilder, getMethods: Int) = builder.addOffset(4, getMethods, 0)
        fun addPutMethods(builder: FlatBufferBuilder, putMethods: Int) = builder.addOffset(5, putMethods, 0)
        fun endFieldMatcher(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
