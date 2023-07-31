// automatically generated by the FlatBuffers compiler, do not modify

package org.luckypray.dexkit.schema

import com.google.flatbuffers.BaseVector
import com.google.flatbuffers.BooleanVector
import com.google.flatbuffers.ByteVector
import com.google.flatbuffers.Constants
import com.google.flatbuffers.DoubleVector
import com.google.flatbuffers.FlatBufferBuilder
import com.google.flatbuffers.FloatVector
import com.google.flatbuffers.LongVector
import com.google.flatbuffers.StringVector
import com.google.flatbuffers.Struct
import com.google.flatbuffers.Table
import com.google.flatbuffers.UnionVector
import java.nio.ByteBuffer
import java.nio.ByteOrder
import kotlin.math.sign

@Suppress("unused")
class ClassMeta : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : ClassMeta {
        __init(_i, _bb)
        return this
    }
    val id : Int
        get() {
            val o = __offset(4)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    val dexId : Int
        get() {
            val o = __offset(6)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    fun annotations(j: Int) : Int {
        val o = __offset(8)
        return if (o != 0) {
            bb.getInt(__vector(o) + j * 4)
        } else {
            0
        }
    }
    val annotationsLength : Int
        get() {
            val o = __offset(8); return if (o != 0) __vector_len(o) else 0
        }
    val annotationsAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(8, 4)
    fun annotationsInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 8, 4)
    val accessFlags : UInt
        get() {
            val o = __offset(10)
            return if(o != 0) bb.getInt(o + bb_pos).toUInt() else 0u
        }
    val dexDescriptor : String?
        get() {
            val o = __offset(12)
            return if (o != 0) {
                __string(o + bb_pos)
            } else {
                null
            }
        }
    val dexDescriptorAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(12, 1)
    fun dexDescriptorInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 12, 1)
    val superClass : Int
        get() {
            val o = __offset(14)
            return if(o != 0) bb.getInt(o + bb_pos) else 0
        }
    fun interfaces(j: Int) : Int {
        val o = __offset(16)
        return if (o != 0) {
            bb.getInt(__vector(o) + j * 4)
        } else {
            0
        }
    }
    val interfacesLength : Int
        get() {
            val o = __offset(16); return if (o != 0) __vector_len(o) else 0
        }
    val interfacesAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(16, 4)
    fun interfacesInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 16, 4)
    val sourceFile : String?
        get() {
            val o = __offset(18)
            return if (o != 0) {
                __string(o + bb_pos)
            } else {
                null
            }
        }
    val sourceFileAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(18, 1)
    fun sourceFileInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 18, 1)
    fun fields(j: Int) : Int {
        val o = __offset(20)
        return if (o != 0) {
            bb.getInt(__vector(o) + j * 4)
        } else {
            0
        }
    }
    val fieldsLength : Int
        get() {
            val o = __offset(20); return if (o != 0) __vector_len(o) else 0
        }
    val fieldsAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(20, 4)
    fun fieldsInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 20, 4)
    fun methods(j: Int) : Int {
        val o = __offset(22)
        return if (o != 0) {
            bb.getInt(__vector(o) + j * 4)
        } else {
            0
        }
    }
    val methodsLength : Int
        get() {
            val o = __offset(22); return if (o != 0) __vector_len(o) else 0
        }
    val methodsAsByteBuffer : ByteBuffer get() = __vector_as_bytebuffer(22, 4)
    fun methodsInByteBuffer(_bb: ByteBuffer) : ByteBuffer = __vector_in_bytebuffer(_bb, 22, 4)
    companion object {
        fun validateVersion() = Constants.FLATBUFFERS_23_5_26()
        fun getRootAsClassMeta(_bb: ByteBuffer): ClassMeta = getRootAsClassMeta(_bb, ClassMeta())
        fun getRootAsClassMeta(_bb: ByteBuffer, obj: ClassMeta): ClassMeta {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        fun createClassMeta(builder: FlatBufferBuilder, id: Int, dexId: Int, annotationsOffset: Int, accessFlags: UInt, dexDescriptorOffset: Int, superClass: Int, interfacesOffset: Int, sourceFileOffset: Int, fieldsOffset: Int, methodsOffset: Int) : Int {
            builder.startTable(10)
            addMethods(builder, methodsOffset)
            addFields(builder, fieldsOffset)
            addSourceFile(builder, sourceFileOffset)
            addInterfaces(builder, interfacesOffset)
            addSuperClass(builder, superClass)
            addDexDescriptor(builder, dexDescriptorOffset)
            addAccessFlags(builder, accessFlags)
            addAnnotations(builder, annotationsOffset)
            addDexId(builder, dexId)
            addId(builder, id)
            return endClassMeta(builder)
        }
        fun startClassMeta(builder: FlatBufferBuilder) = builder.startTable(10)
        fun addId(builder: FlatBufferBuilder, id: Int) = builder.addInt(0, id, 0)
        fun addDexId(builder: FlatBufferBuilder, dexId: Int) = builder.addInt(1, dexId, 0)
        fun addAnnotations(builder: FlatBufferBuilder, annotations: Int) = builder.addOffset(2, annotations, 0)
        fun createAnnotationsVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addInt(data[i])
            }
            return builder.endVector()
        }
        fun startAnnotationsVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addAccessFlags(builder: FlatBufferBuilder, accessFlags: UInt) = builder.addInt(3, accessFlags.toInt(), 0)
        fun addDexDescriptor(builder: FlatBufferBuilder, dexDescriptor: Int) = builder.addOffset(4, dexDescriptor, 0)
        fun addSuperClass(builder: FlatBufferBuilder, superClass: Int) = builder.addInt(5, superClass, 0)
        fun addInterfaces(builder: FlatBufferBuilder, interfaces: Int) = builder.addOffset(6, interfaces, 0)
        fun createInterfacesVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addInt(data[i])
            }
            return builder.endVector()
        }
        fun startInterfacesVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addSourceFile(builder: FlatBufferBuilder, sourceFile: Int) = builder.addOffset(7, sourceFile, 0)
        fun addFields(builder: FlatBufferBuilder, fields: Int) = builder.addOffset(8, fields, 0)
        fun createFieldsVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addInt(data[i])
            }
            return builder.endVector()
        }
        fun startFieldsVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun addMethods(builder: FlatBufferBuilder, methods: Int) = builder.addOffset(9, methods, 0)
        fun createMethodsVector(builder: FlatBufferBuilder, data: IntArray) : Int {
            builder.startVector(4, data.size, 4)
            for (i in data.size - 1 downTo 0) {
                builder.addInt(data[i])
            }
            return builder.endVector()
        }
        fun startMethodsVector(builder: FlatBufferBuilder, numElems: Int) = builder.startVector(4, numElems, 4)
        fun endClassMeta(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}